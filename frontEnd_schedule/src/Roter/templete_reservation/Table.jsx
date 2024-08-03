import React, { useState } from "react";
import Form from "./Form";

const employees = ["Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hannah", "Isaac", "Judy"];
const horaAbertura = "10:00";
const horaFecho = "20:00";

function convertToDate(horaStr) {
    const [hora, minuto] = horaStr.split(":").map(Number);
    const now = new Date();
    now.setHours(hora, minuto, 0, 0);
    return now;
}

function formatTime(date) {
    return date.toTimeString().slice(0, 5);
}

function Employer() {
    return (
        <tr>
            <th>Hora</th>
            {employees.map((employee, index) => (
                <th className="employee" key={index}>{employee}</th>
            ))}
        </tr>
    );
}
function ReplaceCharacter(word) {
    return word.replace(/:/g, '').replace(/\s+/g, '');
}


function Table() {
    const abertura = convertToDate(horaAbertura);
    const fecho = convertToDate(horaFecho);

    const [showForm, setShowForm] = useState(false);
    const [selectedField, setSelectedField] = useState({});
    const [id, setId] = useState();

    const handleCellClick = (employee, hora, id) => {
        setSelectedField({ employee, hora });
        setShowForm(true);
        setId(id)
    };

    const handleUpdateField = (updatedValues) => {

        console.log("Updated Values:", updatedValues);
        const element = document.querySelector(`#${id}`);
        element.innerHTML =`
            <p> ${updatedValues.nome}</p>
             <p> ${updatedValues.profissional}</p>
             <p> ${updatedValues.nome}</p>
             <p> ${updatedValues.servico}</p>
             `;
        setShowForm(false);
    };


    const headers = [];
    let horaAtual = new Date(abertura);

    while (horaAtual <= fecho) {
        headers.push(formatTime(horaAtual));
        horaAtual = new Date(horaAtual.getTime() + 15 * 60 * 1000);
    }

    const rows = headers.map((hora, horaIndex) => (
        <tr key={horaIndex}>
            <td>{hora}</td>
            {employees.map((employee) => (
                <td
                    id={ReplaceCharacter(`${employee}_${hora}`)}

                    key={`${employee}_${hora}`}
                    className="container-marcacao"
                    onClick={() => handleCellClick(employee, hora, ReplaceCharacter(`${employee}_${hora}`))}
                >

                </td>
            ))}
        </tr>
    ));

    return (
        <>
            <table className="container-table">
                <thead>
                    <Employer />
                </thead>
                <tbody>
                    {rows}
                </tbody>
            </table>
            {showForm && <Form field={selectedField} onUpdateField={handleUpdateField} />}
        </>
    );
}

export default Table;
