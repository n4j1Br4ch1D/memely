package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.MemeDto;
import com.memely.memely.entity.Meme;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.MemeRepository;
import com.memely.memely.response.MemeResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemeService {

	private MemeRepository memeRepository;
	private ModelMapper mapper;

	public MemeService(MemeRepository memeRepository, ModelMapper mapper) {
		this.memeRepository = memeRepository;
		this.mapper = mapper;
	}

	public MemeResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Meme> memes;
//		if (role == null && isMale == null && enabled == null) {
			memes = memeRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			memes = memeRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			memes = memeRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Meme> listOfMemes = memes.getContent();
		List<MemeDto> memeContent = listOfMemes.stream().map(meme -> mapToDTO(meme)).collect(Collectors.toList());
		MemeResponse memeResponse = new MemeResponse();
		memeResponse.setContent(memeContent);
		memeResponse.setPageNo(memes.getNumber());
		memeResponse.setPageSize(memes.getSize());
		memeResponse.setTotalElements(memes.getTotalElements());
		memeResponse.setTotalPages(memes.getTotalPages());
		memeResponse.setLast(memes.isLast());
		return memeResponse;
	}
	
	public List<Meme> getMemesByUsername(String username) {
	      List<Meme> memes = memeRepository.findAllByUserUsername(username);
           return memes;
	}
	
	public List<Meme> getMemesByUserId(Long userId) {
	      List<Meme> memes = memeRepository.findAllByUserId(userId);
         return memes;
	}
	
	public List<Meme> getAllFavorites() {
	      List<Meme> memes = memeRepository.getAllFavorites();
         return memes;
	}
	
	
	public List<Meme> getUserFavorites(Long userId) {
	      List<Meme> memes = memeRepository.getUserFavorites(userId);
       return memes;
	}
	
	
	public List<Meme> getAllReactions() {
	      List<Meme> memes = memeRepository.getAllReactions();
       return memes;
	}
	
	
	public List<Meme> getUserReactions(Long id) {
	      List<Meme> memes = memeRepository.getUserReactions(id);
     return memes;
	}
	
	public List<Meme> getAllReports() {
	 List<Meme> memes = memeRepository.getAllReports();
     return memes;
	}
	
	public List<Meme> getUserReports(Long userId) {
	      List<Meme> memes = memeRepository.getUserReports(userId);
          return memes;
	}
	
	
	public List<Meme> getStories() {
	      List<Meme> memes = memeRepository.findAllByStory(true);
         return memes;
	}
	
	public List<Meme> getUserStories(Long userId) {
	      List<Meme> memes = memeRepository.getUserStories(userId);
          return memes;
	}
	
	public List<Meme> getMemesByTag(String tag) {
	      List<Meme> memes = memeRepository.findAllByTagName(tag);
         return memes;
	}
	
	public List<Meme> searchMemes(String keywords) {
	      List<Meme> memes = memeRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keywords, keywords);
         return memes;
	}
	

	public MemeDto getOne(long id) {
		Meme meme = memeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meme", "id", id));
		return mapToDTO(meme);
	}

	public MemeDto create(MemeDto memeDto) {
		Meme meme = mapToEntity(memeDto);
		Meme newMeme = memeRepository.save(meme);
		MemeDto memeResponse = mapToDTO(newMeme);
		return memeResponse;
	}

	public MemeDto update(MemeDto memeDto, long id) {
		Meme meme = memeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meme", "id", id));
		meme.setTitle(memeDto.getTitle());
		Meme updatedMeme = memeRepository.save(meme);
		return mapToDTO(updatedMeme);
	}

	public void delete(long id) {
		Meme meme = memeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meme", "id", id));
		memeRepository.delete(meme);
	}

	private MemeDto mapToDTO(Meme meme) {
		MemeDto memeDto = mapper.map(meme, MemeDto.class);
		return memeDto;
	}

	private Meme mapToEntity(MemeDto memeDto) {
		Meme meme = mapper.map(memeDto, Meme.class);
		return meme;
	}

}
