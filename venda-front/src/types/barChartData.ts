export type BarChartData = {
  labels: {
    categories: string[];
  };
  series: SeriesData[]
}

export type SeriesData = {
  name: string,
  data: number[]
}