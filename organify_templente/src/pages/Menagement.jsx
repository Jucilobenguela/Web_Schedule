import NavBar from "../componentes/navBar/NavBar"
import SectionEmpregados from "../componentes/SectionEmpregados/SectionEmpregados"

function Management(){
     return(
        <section className="container-management">
            <NavBar></NavBar>
            <SectionEmpregados/>

        </section>

     )
}
export default Management