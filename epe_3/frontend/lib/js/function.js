function loadItem(item) {
    const arrItem = ['', 'estudiantes', 'cursos', 'asignaturas', 'profesores'];
    const estructuraBasica = {
        'estudiantes': ['ID', 'Nombre', 'RUT', 'Email', 'Fecha_Nacimiento', 'Direccion', 'Telefono', 'Matricula'],
        'cursos': ['ID', 'Nombre', 'Codigo', 'Descripcion', 'Creditos'],
        'asignaturas': ['ID', 'Nombre', 'Profesor_ID', 'Fecha_Asignacion'],
        'profesores': ['ID', 'Nombre', 'Email', 'Departamento']
    };

    const entidad = arrItem[item];
    const columnas = estructuraBasica[entidad];

    $.ajax({
        method: "GET",
        url: `http://localhost:8080/api/v1/${entidad}/todos`,
        cache: false,
        success: function (datos) { 
            console.log("Datos recibidos:", JSON.stringify(datos, null, 2));

            let tablaHTML = `
                <div class="table-responsive">
                    <table id="tablaDinamica" class="table table-bordered" style="width:100%" cellspacing="0">
                        <thead>
                            <tr>${columnas.map(col => `<th>${col}</th>`).join('')}</tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            `;
            $("#iContainner").html(tablaHTML);
            datos.forEach(item => {
                let fila = '<tr>';
                columnas.forEach(col => {
                    // Para evitar errores con nombres de columnas que no coinciden, se maneja un mapeo dinámico
                    const llave = col.toLowerCase().replace(/\s/g, '_');
                    fila += `<td>${item[llave] || ''}</td>`;
                });
                fila += '</tr>';
                $('#tablaDinamica tbody').append(fila);
            });
            $('#tablaDinamica').DataTable({
                paging: true,
                searching: true,
                ordering: true,
                info: true,
                autoWidth: false,
                dom: 'Bfrtip',
                buttons: [
                    {
                        text: 'Nuevo',
                        action: function () {
                            abrirModalFormulario(entidad, columnas, item);
                            // alert('Agregar nuevo registro');
                        }
                    },
                    {
                        extend: 'selected',
                        text: 'Editar',
                        action: function (e, dt, node, config) {
                            var datosFila = dt.row({ selected: true }).data();
                            alert('Editar registro: ' + JSON.stringify(datosFila));
                        }
                    }
                ],
                select: true // Permitir seleccionar filas para editar
            });
        },
        error: function (xhr, status, error) {
            console.error("Error al cargar los datos:", error);
        }
    });
}

function abrirModalFormulario(entidad, columnas, item) {
    $("#formRegistro").empty();

    columnas.forEach(col => {
        const label = col;
        const id = col.toLowerCase().replace(/\s/g, '_');
        const input = `<div class="form-group">
                        <label for="${id}">${label}</label>
                        <input type="text" class="form-control" id="${id}" name="${id}" required>
                      </div>`;
        $("#formRegistro").append(input);
    });
    $("#modalForm").modal('show');

    $("#btnGuardar").off('click').on('click', function () {
        guardarDatos(entidad, columnas, item);
    });
}

function guardarDatos(entidad, columnas, item) {
    let datos = {};
    columnas.forEach(col => {
        const id = col.toLowerCase().replace(/\s/g, '_');
        datos[id] = $(`#${id}`).val();
    });

    console.log("Datos a enviar:", datos);

    $.ajax({
        method: "POST",
        url: `http://localhost:8080/api/v1/${entidad}/crear`,
        contentType: "application/json",
        data: JSON.stringify(datos),
        success: function (response) {
            alert("Datos guardados exitosamente.");
            $("#modalForm").modal('hide');
            loadItem(item);
        },
        error: function (xhr, status, error) {
            console.error("Error al guardar los datos:", error);
        }
    });
}