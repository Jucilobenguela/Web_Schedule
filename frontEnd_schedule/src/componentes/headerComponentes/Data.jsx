


function Data(){
    let data = new Date();
    let day = data.getDate();
    let month = data.getMonth() + 1; // getMonth() retorna 0-11, então adicionamos 1
    let year = data.getFullYear();
    let weekDay = data.toLocaleDateString('pt-BR', { weekday: 'long' }); // Obtém o nome do dia da semana em português
    return(
        <div className="data">
        <strong>
        {weekDay}
        </strong>
        <strong>
        {day}
        </strong>
        <strong>
        {month}
        </strong>
        <strong>
        {year}
        </strong>
    </div>
    )
}
export default Data