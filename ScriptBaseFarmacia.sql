CREATE DATABASE IF NOT EXISTS farmacia;
USE farmacia;

-- Tabla Cliente
CREATE TABLE Cliente (
    IdCliente INT AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Correo VARCHAR(150) UNIQUE,
    Telefono VARCHAR(15),
    Membresia BOOLEAN,
    CONSTRAINT pk_cliente PRIMARY KEY (IdCliente)
);

-- Tabla Empleado
CREATE TABLE Empleado (
    IdEmpleado INT AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Cargo VARCHAR(50),
    Salario DECIMAL(10,2),
    CONSTRAINT pk_empleado PRIMARY KEY (IdEmpleado)
);

-- Tabla Producto
CREATE TABLE Producto (
    IdProducto INT AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    Stock INT NOT NULL,
    FechaCaducidad DATE,
    Descripcion VARCHAR(150),
    CONSTRAINT pk_producto PRIMARY KEY (IdProducto)
);

-- Tabla Proveedor
CREATE TABLE Proveedor (
    IdProveedor INT AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Correo VARCHAR(150) UNIQUE,
    Telefono VARCHAR(15),
    CONSTRAINT pk_proveedor PRIMARY KEY (IdProveedor)
);

-- Tabla ProveedorProducto (Relación N:M entre Proveedor y Producto)
CREATE TABLE ProveedorProducto (
    IdProveedor INT,
    IdProducto INT,
    CONSTRAINT pk_proveedorproducto PRIMARY KEY (IdProveedor, IdProducto),
    CONSTRAINT fk_proveedorproducto_proveedor FOREIGN KEY (IdProveedor) REFERENCES Proveedor(IdProveedor) ON DELETE CASCADE,
    CONSTRAINT fk_proveedorproducto_producto FOREIGN KEY (IdProducto) REFERENCES Producto(IdProducto) ON DELETE CASCADE
);

-- Tabla Venta
CREATE TABLE Venta (
    IdVenta INT AUTO_INCREMENT,
    IdCliente INT,
    IdEmpleado INT,
    FechaVenta DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_venta PRIMARY KEY (IdVenta),
    CONSTRAINT fk_venta_cliente FOREIGN KEY (IdCliente) REFERENCES Cliente(IdCliente) ON DELETE SET NULL,
    CONSTRAINT fk_venta_empleado FOREIGN KEY (IdEmpleado) REFERENCES Empleado(IdEmpleado) ON DELETE SET NULL
);

-- Tabla VentaDetalle (Relación N:M entre Venta y Producto)
CREATE TABLE VentaDetalle (
    IdVenta INT,
    IdProducto INT,
    Cantidad INT NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    CONSTRAINT pk_ventadetalle PRIMARY KEY (IdVenta, IdProducto),
    CONSTRAINT fk_ventadetalle_venta FOREIGN KEY (IdVenta) REFERENCES Venta(IdVenta) ON DELETE CASCADE,
    CONSTRAINT fk_ventadetalle_producto FOREIGN KEY (IdProducto) REFERENCES Producto(IdProducto) ON DELETE CASCADE
);