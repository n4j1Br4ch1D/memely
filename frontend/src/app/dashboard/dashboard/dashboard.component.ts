  import { Component, OnInit, ViewChild } from '@angular/core';
  import { ChartConfiguration, ChartData, ChartEvent, ChartType } from 'chart.js';
  import { BaseChartDirective } from 'ng2-charts';
  import DataLabelsPlugin from 'chartjs-plugin-datalabels';
  
  @Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss']
  })
  
  export class DashboardComponent implements OnInit {
  
    constructor() { }
  
    ngOnInit(): void {
    }
    @ViewChild(BaseChartDirective) chart: BaseChartDirective | undefined;
  
    public barChartOptions: ChartConfiguration['options'] = {
      responsive: true,
      // We use these empty structures as placeholders for dynamic theming.
      scales: {
        x: {},
        y: {
          min: 10
        }
      },
      plugins: {
        legend: {
          display: true,
        },
        datalabels: {
          anchor: 'end',
          align: 'end'
        }
      }
    };
    public barChartType: ChartType = 'bar';
    public barChartPlugins = [
      DataLabelsPlugin
    ];
  
    public barChartData: ChartData<'bar'> = {
      labels: [ '2006', '2007', '2008', '2009', '2010', '2011', '2012' ],
      datasets: [
        { data: [ 65, 59, 80, 81, 56, 55, 40 ], label: 'Series A' },
        { data: [ 28, 48, 40, 19, 86, 27, 90 ], label: 'Series B' }
      ]
    };
  
  
    public randomize(): void {
      // Only Change 3 values
      this.barChartData.datasets[0].data = [
        Math.round(Math.random() * 100),
        59,
        80,
        Math.round(Math.random() * 100),
        56,
        Math.round(Math.random() * 100),
        40 ];
  
      this.chart?.update();
    }

      // PolarArea
  public polarAreaChartLabels: string[] = [ 'Download Sales', 'In-Store Sales', 'Mail Sales', 'Telesales', 'Corporate Sales' ];
  public polarAreaChartData: ChartData<'polarArea'> = {
    labels: this.polarAreaChartLabels,
    datasets: [ {
      data: [ 300, 500, 100, 40, 120 ],
      label: 'Series 1'
    } ]
  };
  public polarAreaLegend = true;

  public polarAreaChartType: ChartType = 'polarArea';

   // Radar
   public radarChartOptions: ChartConfiguration['options'] = {
    responsive: true,
  };
  public radarChartLabels: string[] = [ 'Eating', 'Drinking', 'Sleeping', 'Designing', 'Coding', 'Cycling', 'Running' ];

  public radarChartData: ChartData<'radar'> = {
    labels: this.radarChartLabels,
    datasets: [
      { data: [ 65, 59, 90, 81, 56, 55, 40 ], label: 'Series A' },
      { data: [ 28, 48, 40, 19, 96, 27, 100 ], label: 'Series B' }
    ]
  };
  public radarChartType: ChartType = 'radar';
  }