import "../../Roter/templete_reservation/View.css"
import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faChevronCircleRight, faChevronCircleLeft, faCalendarDays } from '@fortawesome/free-solid-svg-icons'
import Data from "../headerComponentes/Data";
import Title from "../headerComponentes/Title";
function Header() {
    let data = new Date();
    let day = data.getDate();
    let month = data.getMonth() + 1; // getMonth() retorna 0-11, então adicionamos 1
    let year = data.getFullYear();
    let weekDay = data.toLocaleDateString('pt-BR', { weekday: 'long' }); // Obtém o nome do dia da semana em português


    return (
        <div className="header">
        <div className="nav-view">
            <Title name={"Agenda"} />
            <Data day={day} month={month} year={year} weekDay={weekDay} icon={faCalendarDays}/>   

        </div>
         <div className="icon" >
         <FontAwesomeIcon icon={faChevronCircleLeft} />
         <FontAwesomeIcon   icon={faChevronCircleRight} />
             
         </div>
         </div>
    );
}

export default Header;