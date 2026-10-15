# 📄 Simulación de Lector de Documentos Multiformato (POO y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de procesamiento y lectura de archivos con diferentes extensiones (PDF, Word y TXT). Pone en práctica conceptos clave de la **Programación Orientada a Objetos (POO)** como **clases abstractas**, **herencia**, **validación de formatos por extensión**, **manejo de colecciones dinámicas** y **polimorfismo** en tiempo de ejecución.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una superclase abstracta y múltiples implementaciones especializadas para cada tipo de documento:

*   **`LectorDocumento` (Clase Abstracta)**: Define el contrato genérico que todo lector de archivos debe cumplir.
    *   **Métodos abstractos obligatorios:** 
        *   `abrirArchivo(String ruta)`: Gestiona la apertura y validación del formato correspondiente.
        *   `extraerTexto()`: Retorna el contenido extraído del documento.
*   **`LectorPDF`**: Modela el lector especializado en archivos con extensión `.pdf`.
    *   **Comportamiento:** Valida que la ruta termine en `.pdf` (ignorando mayúsculas/minúsculas) antes de procesar la lectura.
*   **`LectorWord`**: Modela el lector especializado en documentos de texto enriquecido con extensión `.docx`.
    *   **Comportamiento:** Valida de forma estricta la extensión `.docx` antes de cargar el texto simulado.
*   **`LectorTextoPlano`**: Modela el lector para archivos de texto plano con extensión `.txt`.
    *   **Comportamiento:** Valida la compatibilidad con el formato `.txt`.
*   **`Main`**: Punto de entrada del programa. Administra una lista de archivos con extensiones válidas e inválidas (`ArrayList<String>`), evalúa dinámicamente qué instancia de lector crear mediante estructuras condicionales, y procesa la extracción de texto de forma unificada.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Validación Defensiva por Extensión:** Antes de abrir un archivo, cada clase concreta corrobora mediante métodos de cadena (`toLowerCase().endsWith(...)`) que la ruta pertenezca al formato soportado. Si no coincide, imprime un error por la salida de sistema y detiene la ejecución.
2. **Asignación Polimórfica Condicional:** En el ciclo principal (`Main`), el sistema analiza la extensión del archivo para instanciar el lector adecuado (`new LectorPDF()`, `new LectorWord()`, etc.) y asignarlo a una variable de tipo abstracto (`LectorDocumento lector`).
3. **Manejo de Formatos Desconocidos:** Si un archivo posee una extensión no soportada (ej. `imagen.jpg`), el sistema evalúa que el objeto lector permanece como `nulo` (`lector != null`), informando de manera controlada que el formato no es compatible sin interrumpir el flujo del programa.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
PDF abierto: informe.pdf
Contenido: Texto extraído del archivo PDF
----------------------
Word abierto: documento.docx
Contenido: Texto extraído del archivo Word
----------------------
TXT abierto: notas.txt
Contenido: Texto extraído del archivo de texto plano
----------------------
Formato no compatible: imagen.jpg
