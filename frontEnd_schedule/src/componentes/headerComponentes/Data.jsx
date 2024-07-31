


function Data({ day, month, year, weekDay }) {
 
    return (
        <div className="data">
            <p>{weekDay}</p>
            <p>{day}</p>
            <p>{month}</p>
            <p>{year}</p>

        </div>
    )
}
export default Data