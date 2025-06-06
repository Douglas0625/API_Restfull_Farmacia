API RESTful Farmacia 💊

Este proyecto es una API RESTful desarrollada en Java utilizando Spring Boot e IntelliJ IDEA, que permite gestionar una farmacia. Incluye operaciones CRUD para clientes, empleados, productos, proveedores, ventas y más. La API está conectada a una base de datos MySQL, manejada a través de **XAMPP** y **MySQL Workbench**.


---

✨ Características

- CRUD de clientes, empleados, productos y proveedores
- Gestión de ventas y detalles de ventas
- Relaciones N:M entre productos y proveedores, ventas y productos
- Pruebas de endpoints mediante Postman

---

🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- MySQL Workbench
- XAMPP (servidor de base de datos local)
- Postman
- IntelliJ IDEA

---

🚀 Instalación

1. Clona el repositorio**
   ```bash
   git clone https://github.com/Douglas0625/API_Restfull_Farmacia.git
   cd API_Restfull_Farmacia
   ```

2. Abre el proyecto en IntelliJ IDEA**

3. Configura el archivo `application.properties`** (en `src/main/resources/`):
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/farmacia
   spring.datasource.username=root
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. Instala dependencias y construye el proyecto**
   - IntelliJ descargará las dependencias automáticamente al abrir el proyecto.
   - Asegúrate de tener configurado Java 17.

---

 🗃️ Configuración de la base de datos

1. Abre **XAMPP** y asegúrate de iniciar el módulo **MySQL**.
2. Abre **MySQL Workbench** y ejecuta el siguiente script SQL:

   ```sql
   CREATE DATABASE IF NOT EXISTS farmacia;
   USE farmacia;

   CREATE TABLE Cliente (
       IdCliente INT AUTO_INCREMENT,
       Nombre VARCHAR(50) NOT NULL,
       Apellido VARCHAR(50) NOT NULL,
       Correo VARCHAR(150) UNIQUE,
       Telefono VARCHAR(15),
       Membresia BOOLEAN,
       CONSTRAINT pk_cliente PRIMARY KEY (IdCliente)
   );

   CREATE TABLE Empleado (
       IdEmpleado INT AUTO_INCREMENT,
       Nombre VARCHAR(50) NOT NULL,
       Apellido VARCHAR(50) NOT NULL,
       Cargo VARCHAR(50),
       Salario DECIMAL(10,2),
       CONSTRAINT pk_empleado PRIMARY KEY (IdEmpleado)
   );

   CREATE TABLE Producto (
       IdProducto INT AUTO_INCREMENT,
       Nombre VARCHAR(100) NOT NULL,
       Precio DECIMAL(10,2) NOT NULL,
       Stock INT NOT NULL,
       FechaCaducidad DATE,
       Descripcion VARCHAR(150),
       CONSTRAINT pk_producto PRIMARY KEY (IdProducto)
   );

   CREATE TABLE Proveedor (
       IdProveedor INT AUTO_INCREMENT,
       Nombre VARCHAR(100) NOT NULL,
       Correo VARCHAR(150) UNIQUE,
       Telefono VARCHAR(15),
       CONSTRAINT pk_proveedor PRIMARY KEY (IdProveedor)
   );

   CREATE TABLE ProveedorProducto (
       IdProveedor INT,
       IdProducto INT,
       CONSTRAINT pk_proveedorproducto PRIMARY KEY (IdProveedor, IdProducto),
       CONSTRAINT fk_proveedorproducto_proveedor FOREIGN KEY (IdProveedor) REFERENCES Proveedor(IdProveedor) ON DELETE CASCADE,
       CONSTRAINT fk_proveedorproducto_producto FOREIGN KEY (IdProducto) REFERENCES Producto(IdProducto) ON DELETE CASCADE
   );

   CREATE TABLE Venta (
       IdVenta INT AUTO_INCREMENT,
       IdCliente INT,
       IdEmpleado INT,
       FechaVenta DATETIME DEFAULT CURRENT_TIMESTAMP,
       CONSTRAINT pk_venta PRIMARY KEY (IdVenta),
       CONSTRAINT fk_venta_cliente FOREIGN KEY (IdCliente) REFERENCES Cliente(IdCliente) ON DELETE SET NULL,
       CONSTRAINT fk_venta_empleado FOREIGN KEY (IdEmpleado) REFERENCES Empleado(IdEmpleado) ON DELETE SET NULL
   );

   CREATE TABLE VentaDetalle (
       IdVenta INT,
       IdProducto INT,
       Cantidad INT NOT NULL,
       Precio DECIMAL(10,2) NOT NULL,
       CONSTRAINT pk_ventadetalle PRIMARY KEY (IdVenta, IdProducto),
       CONSTRAINT fk_ventadetalle_venta FOREIGN KEY (IdVenta) REFERENCES Venta(IdVenta) ON DELETE CASCADE,
       CONSTRAINT fk_ventadetalle_producto FOREIGN KEY (IdProducto) REFERENCES Producto(IdProducto) ON DELETE CASCADE
   );
   ```

---

▶️ Ejecución del proyecto

1. Ejecuta la clase principal del proyecto (la que contiene `@SpringBootApplication`).
2. La API estará disponible en:  
   ```
   http://localhost:8080
   ```

---

📬 Uso de la API (con Postman)

Puedes usar [Postman](https://www.postman.com/) para probar los endpoints disponibles.

# Ejemplos de endpoints

- `GET /clientes` → Lista todos los clientes  
- `POST /clientes` → Crea un nuevo cliente  
- `PUT /clientes/{id}` → Actualiza un cliente  
- `DELETE /clientes/{id}` → Elimina un cliente

(Lo mismo para `/empleados`, `/productos`, `/proveedores`, etc.)

Puedes importar una colección de Postman con las rutas (si la tienes) o usar el modo manual.

---

🧩 Estructura de la base de datos

La base de datos incluye las siguientes entidades:

- **Cliente**
- **Empleado**
- **Producto**
- **Proveedor**
- **ProveedorProducto** (N:M)
- **Venta**
- **VentaDetalle** (N:M)

Relaciones implementadas con claves foráneas y borrado en cascada donde aplica.
---

 📄 Licencia

Este proyecto se encuentra bajo la licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente.
