import { SalePage } from "types/sale";

type Props = {
  page: SalePage;
  onPageChange: Function;
}

const Pagination = ({ page, onPageChange }: Props) => {
  return (
    <div className="row d-flex justify-content-center">
      <nav>
        <ul className="pagination">
          <li className={`page-item ${page.first ? 'disabled' : ''}`}>
            <span title="Primeira Página" style={{cursor:'pointer'}} className="page-link" onClick={() => onPageChange(0)}>&laquo;</span>
          </li>
          <li className={`page-item ${page.first ? 'invisible' : ''}`}>
            <span title="Página Anterior" style={{cursor:'pointer'}} className="page-link" onClick={() => onPageChange(page.number - 1)}>{page.number}</span>
          </li>
          <li className="page-item disabled">
            <span className="page-link">{page.number + 1}</span>
          </li>
          <li className={`page-item ${page.last ? 'invisible' : ''}`}>
            <span title="Próxima Página" style={{cursor:'pointer'}} className="page-link" onClick={() => onPageChange(page.number + 1)}>{page.number + 2}</span>
          </li>
          <li className={`page-item ${page.last ? 'disabled' : ''}`}>
            <span title="Última Página" style={{cursor:'pointer'}} className="page-link" onClick={() => onPageChange(page.totalPages - 1)}>&raquo;</span>
          </li>
        </ul>
      </nav>
    </div>

  )
}

export default Pagination;