import React, { useEffect, useState, useRef } from "react";
import axios from "axios";
import Contenedor from "./Contenedor";

const Filter = ({ path, idReport }) => {
  const inputRefs = useRef({});
  const [data, setData] = useState(null);
  const [button, setButton] = useState(null);
  const [loadReporte, setLoadReporte] = useState(null);
  const [inputValues, setInputValues] = useState(null);

  const getFiltros = async () => {
    try {
      const response = await axios.get("http://localhost:5000/getFiltros/" + idReport);
      setData(response.data.response);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const getButton = async () => {
    try {
      const resbutton = await axios.get("http://localhost:5000/getButton/" + idReport);
      setButton(resbutton.data.response[0]);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const getInputValues = () => {
    const values = {};
    for (const key in inputRefs.current) {
      if (inputRefs.current[key]) {
        values[key] = inputRefs.current[key].value;
      }
    }
    return values;
  };

  const handleButtonClick = () => {
    const values = getInputValues();
    setInputValues(values);
  };

  useEffect(() => {
    getFiltros();
    getButton();
  }, []);

  const renderInput = (item) => {
    switch (item.id_objeto_tipo) {
      case "1":
        return <input type="date" ref={(el) => (inputRefs.current[item.id_index] = el)} className="form-control" placeholder={item.placeholder} />;
      case "2":
        return (
          <select ref={(el) => (inputRefs.current[item.id_index] = el)} className="form-control">
            {item.value_op.split(',').map((option, index) => (
              <option key={index} value={option}>{option}</option>
            ))}
          </select>
        );
      case "3":
        return <input type="text" ref={(el) => (inputRefs.current[item.id_index] = el)} className="form-control" placeholder={item.placeholder} />;
      default:
        return <input type="text" ref={(el) => (inputRefs.current[item.id_index] = el)} className="form-control" placeholder={item.placeholder} />;
    }
  };

  return (
    <div>
      <div className="card">
        <div className="card-header">
          <h3 className="card-title">Filtros para {path} del {idReport}</h3>
        </div>
        <div className="card-body">
          <div className="row">
            {data ? data.map(item => (
              <div key={item.id} className="col-3">
                <label htmlFor={item.id_index}>{item.label}</label>
                {renderInput(item)}
              </div>
            )) : <p>Cargando filtros...</p>}
          </div>
        </div>
        <div className="card-body">
          <div className="row">
            {button ? <div className="col-12"><button className="btn btn-primary btn-block" onClick={handleButtonClick}>{button.name_button}</button></div>
              : <p>Cargando Botón...</p>}
          </div>
        </div>

        {inputValues ? <Contenedor data={inputValues} action={button.action_button} idReport={idReport} /> : ""}
      </div>
    </div>
  );
}

export default Filter;
