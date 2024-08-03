import { faCalendarAlt } from "@fortawesome/free-solid-svg-icons/faCalendarAlt";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { useState } from "react"
import Calendar from "react-calendar";



function Data() {
    const toUpperCase = (word) => {
        return word.split(/[\s-]+/)
            .map(string => string.charAt(0).toUpperCase() + string.slice(1).toLowerCase())
            .join('-');
    }
    const datesPart = (date) => {
        const weekday = date.toLocaleDateString('pt-BR', { weekday: 'long' });// Obtém o nome do dia da semana em português
        return [
            toUpperCase(weekday),
            date.getDate(),
            date.getMonth() + 1, // getMonth() retorna 0-11, então adicionamos 1
            date.getFullYear()

        ]
    }

    const [showCalendar, setShowCalendar] = useState(false);
    const [selectDate, setSelectDate] = useState(new Date())
    const alternarCalendario = () => {
        setShowCalendar(!showCalendar)
    };
    const changeDate = (date) => {
        setSelectDate(date);
        setShowCalendar(false)
    }
    let now = datesPart(selectDate);

    return (
        <div className="data">
            <p>{now[0]} </p>{/*Nome do dia da semana*/}
            <p>{now[1]} -</p>{/*dia do mes*/}
            <p>{now[2]} -</p>{/*mês*/}
            <p>{now[3]}</p>{/*Ano*/}
            <div className="icon-date">
                <FontAwesomeIcon icon={faCalendarAlt}
                    onClick={alternarCalendario}
                />
                {showCalendar && (<div>
                    <Calendar onChange={changeDate} />
                </div>)}

            </div>

        </div>
    )
}
export default Data