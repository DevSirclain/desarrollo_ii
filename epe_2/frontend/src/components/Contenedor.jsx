import React, { useState, useEffect } from "react";
import axios from "axios";

const Contenedor = (props) => {
    console.log(" Contenedor ==> ",props);
    const [response, setResponse] = useState(null);
    const [columns, setColumns] = useState(null);

    const createQueryString = (obj) => {
        const params = new URLSearchParams();
        for (const key in obj) {
            if (typeof obj[key] === 'object') {
                for (const subKey in obj[key]) {
                    params.append(subKey, obj[key][subKey]);
                }
            } else {
                params.append(key, obj[key]);
            }
        }
        return params.toString();
    };
    

    const getReport = async () => {
        try {
            const queryString = createQueryString({ data: props.data, action: props.action });
            console.log(`http://localhost:5000/getReporte/${props.idReport}/?${queryString}`);
            const result = await axios.get(`http://localhost:5000/getReporte/${props.idReport}/?${queryString}`);
            setResponse(result.data.data.response);
            setColumns(result.data.data.columns);

            console.log('KK',result.data.data);
        } catch (error) {
            console.error("Error fetching data:", error);
        }
    };
      
    useEffect(() => {
        getReport();
      }, []);


    return (
        <div>
            <section className="content">
                <div className="card">
                    <div className="card-header">
                        <h3 className="card-title">Fixed Header Table</h3>
                        <div className="card-tools">
                            <div className="input-group input-group-sm" style={{ width: 150 }}>
                                <input type="text" name="table_search" className="form-control float-right" placeholder="Search" />
                                <div className="input-group-append">
                                    <button type="submit" className="btn btn-default">
                                        <i className="fas fa-search" />
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    {response ?
                        <div className="card-body table-responsive p-0">
                            <table className="table table-head-fixed text-nowrap">
                                <thead>
                                    <tr>
                                        {columns.map((col, index) => (
                                            <th key={index}>{col}</th>
                                        ))}
                                    </tr>
                                </thead>
                                <tbody>
                                    {response.map((row, index) => (
                                        <tr key={index}>
                                            {columns.map((col, colIndex) => (
                                                <td key={colIndex}>{row[col]}</td>
                                            ))}
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>
                        : <p>Cargando Datos...</p>
                    }
                </div>
            </section>
        </div>

    );
}

export default Contenedor;