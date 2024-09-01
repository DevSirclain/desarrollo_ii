import React, { useEffect, useState } from "react";
import { useParams } from 'react-router-dom';
import axios from "axios";
import Filter from "../components/Filter";

const Reportes = (props) => {
    let { path, idReport } = useParams();

    return (
        <div>
            <div className="content-wrapper">
                <Filter path={path} idReport={idReport} />
            </div>
        </div>
    );
};

export default Reportes;
