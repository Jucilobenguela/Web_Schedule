import React, { useState, useEffect } from "react";

function Form({ field, onUpdateField }) {
    const [inputValues, setInputValues] = useState({
        horario: '',
        profissional: '',
        name: '',
        servico: ''
    });

    useEffect(() => {
        if (field) {
            setInputValues({
                horario: field.hora || '',
                profissional: field.employee || '',
                name: field.name || '',
                servico: field.servico || ''
            });
        }
    }, [field]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setInputValues(prevValues => ({
            ...prevValues,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault(); 
        if (onUpdateField) {
            onUpdateField(inputValues); 
        }
    };

    return (
        <div className='container-form'>
            <h3>Edit Field</h3>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Horario:</label>
                    <input
                        type="time"
                        name="horario"
                        value={inputValues.horario}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Profissional:</label>
                    <input
                        type="text"
                        name="profissional"
                        value={inputValues.profissional}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={inputValues.name}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Serviço:</label>
                    <input
                        type="text"
                        name="servico"
                        value={inputValues.servico}
                        onChange={handleChange}
                    />
                </div>
                <button type="submit">Salvar</button>
            </form>
        </div>
    );
}

export default Form;