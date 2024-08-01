import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { useState } from "react"
import Calendar from "react-calendar";



function Data({ day, month, year, weekDay, icon }) {
    const [showCalendar, setShowCalendar] = useState(false);
    const alternarCalendario = () => {
        setShowCalendar(!showCalendar)};
 
    return (
        <div className="data">
            <p>{weekDay}</p>
            <p>{day}</p>
            <p>{month}</p>
            <p>{year}</p>
            <div className="icon-date">
               <FontAwesomeIcon icon={icon}
               onClick={alternarCalendario}
               />
               {showCalendar && (<div>
                <Calendar/>
               </div>)}
               
            </div>

        </div>
    )
}
export default Data