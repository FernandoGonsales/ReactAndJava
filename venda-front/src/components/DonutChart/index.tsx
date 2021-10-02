import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { DonutChartData } from 'types/donutChartData';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

const DonutChart = () => {

  const [chartData, setChartData] = useState<DonutChartData>({ labels: ["CARREGANDO...", "CARREGANDO...", "CARREGANDO...", "CARREGANDO..."], series: [] })

  useEffect(() => {
    axios.get(`${BASE_URL}/amount-by-seller`)
      .then(response => {
        const data = response.data as SaleSum[];
        const myLabels = data.map(x => x.sellerName);
        const mySeries = data.map(x => x.sum);
        setChartData({ labels: myLabels, series: mySeries });
      });
  }, []);

  const options = {
    legend: {
      show: true
    }
  }

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height="280"
    />
  );
}

export default DonutChart;
