import React, { useEffect, useState } from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import axios from "axios";

const SideNav = () => {
    const [menu, setMenu] = useState({}); // Cambia el estado inicial a un objeto vacío

    const getMenu = async () => {
        try {
            const response = await axios.get("http://localhost:5000/getMenu");
            const data = response.data;

            // Agrupar los datos por 'n_padre'
            const groupedData = data.reduce((acc, item) => {
                const { n_padre } = item;
                if (!acc[n_padre]) {
                    acc[n_padre] = [];
                }
                acc[n_padre].push(item);
                return acc;
            }, {});

            setMenu(groupedData);
        } catch (error) {
            console.error("Error fetching data:", error);
        }
    };

    useEffect(() => {
        getMenu();
    }, []);

    return (
        <div>
            <aside className="main-sidebar sidebar-dark-primary elevation-4">
                <a href="index.html" className="brand-link">
                    <span className="brand-text font-weight-light">Sistema Prueba</span>
                </a>
                <div className="sidebar">
                    <nav className="mt-2">
                        <ul className="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            {Object.keys(menu).map((parent, index) => (
                                <li key={index} className="nav-item menu-open">
                                    <a href="#" className="nav-link active">
                                        <i className="nav-icon fas fa-tachometer-alt" />
                                        <p>{parent}<i className="right fas fa-angle-left" /></p>
                                    </a>
                                    <ul className="nav nav-treeview">
                                        {menu[parent].map((child, childIndex) => (
                                            <li key={childIndex} className="nav-item">
                                                <a href={`/${child.path}/${child.id}`} className="nav-link">
                                                    {/* <i className="nav-icon fas fa-tachometer-alt" /> */}
                                                    <i className={`nav-icon ${child.ico_fa}`} />
                                                    <p>{child.n_hijo}</p>
                                                </a>
                                            </li>
                                        ))}
                                    </ul>
                                </li>
                            ))}
                        </ul>
                    </nav>
                </div>
            </aside>
        </div>
    );
};

export default SideNav;