import React from "react";

// Dados dos funcionários e horários
//Depois será pego na base de dados, funcionaros, horarios de abertura como do fecho
const employees = ["Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hannah", "Isaac", "Judy"];
const horaAbertura = "10:00";
const horaFecho = "20:00";


// Função para converter string para objeto Date
function convertToDate(horaStr) {
    let [hora, minuto] = horaStr.split(":").map(Number);
    let now = new Date();
    now.setHours(hora, minuto, 0, 0);
    return now;
}

// Função para formatar o objeto Date para "HH:MM"
function formatTime(date) {
    return date.toTimeString().slice(0, 5);
}

// Componente Employer para criar os cabeçalhos dos funcionários
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


function Table() {
    const abertura = convertToDate(horaAbertura);
    const fecho = convertToDate(horaFecho);

    // Gerar cabeçalhos de horários
    const headers = [];
    let horaAtual = new Date(abertura);

    while (horaAtual <= fecho) {
        headers.push(formatTime(horaAtual));
        horaAtual = new Date(horaAtual.getTime() + 15 * 60 * 1000);
    }

    // Gerar linhas da tabela para cada horário
    const rows = headers.map((hora, horaIndex) => (
        <tr key={horaIndex}>
            <td>{hora}</td>
            {employees.map((employeeIndex) => (
                <td key={employeeIndex}
                    className="container-marcacao"
                    type="text"
                    name={`input_${hora}_${employeeIndex}`}
                    placeholder="">
                </td>
            ))}
        </tr>
    ));

    return (
        <table>
            <thead>
                <Employer />
            </thead>
            <tbody>
                {rows}
            </tbody>
        </table>
    );
}

export default Table;