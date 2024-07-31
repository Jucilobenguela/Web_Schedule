import "../../Roter/templete_reservation/View.css"
import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faChevronCircleRight, faChevronCircleLeft } from '@fortawesome/free-solid-svg-icons'
import Data from "../headerComponentes/Data";
import Title from "../headerComponentes/Title";
function Header() {


    return (
        <div className="nav-view">
            <Title name={"Agenda"} />
            <Data />
            <FontAwesomeIcon icon={faChevronCircleLeft} />
            <FontAwesomeIcon icon={faChevronCircleRight} />
        </div>
    );
}

export default Header;