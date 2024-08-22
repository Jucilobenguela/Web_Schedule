import AddEmpregados from "../componentes/AddEmpregados/AddEmpregados"
import NavBar from "../componentes/navBar/NavBar"
import SectionAgenda from "../componentes/SectionAgenda/SectionAgenda"
import SectionEmpregados from "../componentes/SectionEmpregados/SectionEmpregados"

import { useState } from 'react'
import SectionService from "../componentes/SectionService/SectionService"
import SectionRelatorioEstatistica from "../componentes/SectionRelatorioEstatistica/SectionRelatorioEstatistica"

function Management(){
   const [isVisivelsectionEmpregado, setIsVisivelsectionEmpregado] = useState(false);
   const[isVisivelsectionAgenda, setIsVisivelsectionAgenda] = useState(false);
   const[isVisivelSectionService, setIsVisivelSectionService] = useState(false);
   const[isVisivelSectionRelatorioEstatistica, setIsVisivelSectionRelatorioEstatistica] = useState(false);
   const showSectionEmpregados = ()=>{
      setIsVisivelsectionEmpregado(true);
      setIsVisivelsectionAgenda(false);
      setIsVisivelSectionService(false);
      setIsVisivelSectionRelatorioEstatistica(false);
   }
   const showSectionAgenda = ()=>{
      setIsVisivelsectionAgenda(true)
      setIsVisivelsectionEmpregado(false)
      setIsVisivelSectionService(false);
      setIsVisivelSectionRelatorioEstatistica(false);
   }

   const showSectionService = ()=>{
      setIsVisivelsectionAgenda(false)
      setIsVisivelsectionEmpregado(false)
      setIsVisivelSectionService(true);
      setIsVisivelSectionRelatorioEstatistica(false);
   }

   const showSectionRelatorioEstatistica = ()=>{
      setIsVisivelsectionAgenda(false)
      setIsVisivelsectionEmpregado(false)
      setIsVisivelSectionService(false);
      setIsVisivelSectionRelatorioEstatistica(true);
   }
   
     return(
        <section className="container-management">
            <NavBar funcEmpregado={showSectionEmpregados} funcAgenda={showSectionAgenda} funcService={showSectionService} funcRelatiroEstatistica={showSectionRelatorioEstatistica}></NavBar>
           <SectionEmpregados status={isVisivelsectionEmpregado}/>
           <SectionAgenda status={isVisivelsectionAgenda}/>
           <SectionService status={isVisivelSectionService}/>
            <SectionRelatorioEstatistica status={isVisivelSectionRelatorioEstatistica}/> 
        </section>

     )
    
}
export default Management