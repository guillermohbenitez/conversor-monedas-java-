# 💱 Conversor de Monedas en Java

Aplicación de consola desarrollada en Java que permite convertir entre distintas monedas en tiempo real utilizando la API de ExchangeRate. Ideal para practicar integración de APIs, manejo de errores, persistencia de datos y diseño modular.

---

## 🎯 Funcionalidades

- ✅ Conversión entre monedas internacionales
- 📡 Consulta de tasas en tiempo real vía ExchangeRate API
- 🧠 Validación de entradas y manejo de errores
- 📝 Historial de conversiones guardado en archivo JSON
- 🖥️ Interfaz de consola clara y amigable

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Uso |
|------------|-----|
| Java 17+   | Lenguaje principal |
| Maven      | Gestión de dependencias y compilación |
| Gson       | Lectura y escritura de JSON |
| ExchangeRate API | Fuente de datos de conversión |


📁 Estructura del proyecto
ConversorMonedas/
├── src/main/java/com/aluracursos/conversor/
│   ├── app/
│   ├── interfaz/
│   └── servicios/
├── historial.json
├── pom.xml
└── README.md


---

## 📦 Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/conversor-monedas-java.git
cd conversor-monedas-java
```

⚠️​ Editá el archivo ServicioTasaCambio.java y reemplazá:

private static final String API_KEY = "TU_API_KEY";

👉​ Por tu clave real obtenida en ExchangeRate API.



🧪 Ejemplo de uso

![Menú principal](img/1.png)

![Realizar conversión](img/2.png)

![Selección modeda de origen](img/3.png)

![Ingrese la cantidad a convertir](img/4.png)

![Guardar conversión](img/5.png)

![Historial de conversiones](img/6.png)

![Salir del programa](img/7.png)

🤝 Contribuciones
¿Querés agregar nuevas monedas, mejorar la interfaz o extenderlo a una app gráfica? ¡Toda mejora es bienvenida! Abrí un issue o hacé un pull request.

👤 Autor
Guillermo
Estudiante de la Tecnicatura en Desarrollo de Software. Practicante de Alura Cursos.
📧 Contacto: [guillehbenitez@gmail.com]

📄 Licencia
Este proyecto está bajo la licencia MIT. Podés usarlo, modificarlo y compartirlo libremente.



