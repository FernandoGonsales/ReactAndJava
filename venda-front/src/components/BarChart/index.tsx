import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { BarChartData } from 'types/barChartData';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

const BarChart = () => {

  const [chartData, setChartData] = useState<BarChartData>({ labels: { categories: ["CARREGANDO...", "CARREGANDO...", "CARREGANDO..."] }, series: [{ name: "", data: [] }] });

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };

  useEffect(() => {
    axios.get(`${BASE_URL}/success-by-seller`)
      .then(response => {
        const data = response.data as SaleSuccess[];
        const myLabels = data.map(x => x.sellerName);
        const mySeries = data.map(x => round(100.0 * x.deals / x.visited, 1));

        setChartData({
          labels: {
            categories: myLabels
          }, series: [
            {
              name: '% de vendas em relação a quantidade de visitas',
              data: mySeries
            }]
        });
      });
  }, []);

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="280"
    />
  );
}

export default BarChart;
