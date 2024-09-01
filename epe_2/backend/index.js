import express from 'express';
import cors from 'cors';
import axios from 'axios';
import jwt from 'jsonwebtoken';


const app = express();
app.use(cors());
app.use(express.json()); // Para parsear JSON

// Obtener todas las tareas
app.get("/getTareas", async (req, res) => {
    try {
        const response = await axios.get("http://localhost:8000/api/tareas");
        res.json(response.data); // Envía la respuesta de la API al cliente
    } catch (error) {
        console.error("Error fetching tasks:", error);
        res.status(500).json({ message: "Error fetching tasks" });
    }
});

// Obtener una tarea por ID
app.get("/getTarea/:id", async (req, res) => {
    try {
        const response = await axios.get(`http://localhost:8000/api/tareas/${req.params.id}`);
        res.json(response.data); // Envía la respuesta de la API al cliente
    } catch (error) {
        console.error("Error fetching task:", error);
        res.status(500).json({ message: "Error fetching task" });
    }
});

// Crear una nueva tarea
app.post("/createTarea", async (req, res) => {
    try {
        const response = await axios.post("http://localhost:8000/api/tareas", req.body);
        res.json(response.data); // Envía la respuesta de la API al cliente
    } catch (error) {
        console.error("Error creating task:", error);
        res.status(500).json({ message: "Error creating task" });
    }
});

// Actualizar una tarea
app.put("/updateTarea/:id", async (req, res) => {
    try {
        const response = await axios.put(`http://localhost:8000/api/tareas/${req.params.id}`, req.body);
        res.json(response.data); // Envía la respuesta de la API al cliente
    } catch (error) {
        console.error("Error updating task:", error);
        res.status(500).json({ message: "Error updating task" });
    }
});

// Eliminar una tarea
app.delete("/deleteTarea/:id", async (req, res) => {
    try {
        await axios.delete(`http://localhost:8000/api/tareas/${req.params.id}`);
        res.status(204).send(); // Responde con status 204 No Content
    } catch (error) {
        console.error("Error deleting task:", error);
        res.status(500).json({ message: "Error deleting task" });
    }
});

// Obtener todos los usuarios
app.get("/getUsuarios", async (req, res) => {
    try {
        const response = await axios.get("http://localhost:8000/api/usuarios");
        res.json(response.data); // Envía la respuesta de la API al cliente
    } catch (error) {
        console.error("Error fetching users:", error);
        res.status(500).json({ message: "Error fetching users" });
    }
});

// Obtener un usuario por ID
app.get("/getUsuario/:id", async (req, res) => {
    try {
        const response = await axios.get(`http://localhost:8000/api/usuarios/${req.params.id}`);
        res.json(response.data); // Envía la respuesta de la API al cliente
    } catch (error) {
        console.error("Error fetching user:", error);
        res.status(500).json({ message: "Error fetching user" });
    }
});

// Crear un nuevo usuario
app.post("/createUsuario", async (req, res) => {
    try {
        const response = await axios.post("http://localhost:8000/api/usuarios", req.body);
        res.json(response.data); // Envía la respuesta de la API al cliente
    } catch (error) {
        console.error("Error creating user:", error);
        res.status(500).json({ message: "Error creating user" });
    }
});

// Actualizar un usuario
app.put("/updateUsuario/:id", async (req, res) => {
    try {
        const response = await axios.put(`http://localhost:8000/api/usuarios/${req.params.id}`, req.body);
        res.json(response.data); // Envía la respuesta de la API al cliente
    } catch (error) {
        console.error("Error updating user:", error);
        res.status(500).json({ message: "Error updating user" });
    }
});

// Eliminar un usuario
app.delete("/deleteUsuario/:id", async (req, res) => {
    try {
        await axios.delete(`http://localhost:8000/api/usuarios/${req.params.id}`);
        res.status(204).send(); // Responde con status 204 No Content
    } catch (error) {
        console.error("Error deleting user:", error);
        res.status(500).json({ message: "Error deleting user" });
    }
});



app.listen(5000, () => console.log('backend iniciado'));
