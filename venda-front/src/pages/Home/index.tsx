import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <>
      <NavBar />
      <div className="container">
        <div className="jumbotron">
          <h1 className="display-5">Relatório de Vendas</h1>
          <p className="lead">Analise o relatório de vendas da sua empresa por diferentes perspectivas.</p>
          <hr />
          <p>Esta aplicação consiste em exibir um dashboard (React) a partir de dados fornecidos por uma API (Java - Spring)</p>
          <p>Também conta com Heroku, Netilify, CI/CD, Postgree e Swagger.</p>
          <Link className="btn btn-primary btn-md" to="/dashboard">
            Acessar Dashboard
          </Link>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default Home;
