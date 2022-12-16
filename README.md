
# Self Improvement App

Sebuah aplikasi untuk Back-end yang dibuat menggunakan Java SDK 11, menggunakan Springboot (IoC), Java Stream dan Native Query.

Aplikasi ini dibuat untuk melihat perkembangan karyawan dalam masa training, aplikasi ini dapat mendaftarkan karyawan, mendaftarkan learning path dan menambahkan syllabus.

Untuk menngunakan aplikasi ini, silahkan clone terlebih dahulu dari repository ini


## Environment Variables

Untuk menjalankan aplikasi ini, edit Environment Variables sesuai dengan kebutuhan

`API_PORT` : Sesuaikan dengan port local yang ingin dijalankan

`DB_HOST` : Sesuaikan dengan database host yang digunakan (default = localhost)

`DB_NAME` : Nama database yang digunakan untuk menampung data dari aplikasi

`DB_PORT` : Port yang digunakan untuk menjalankan database (postgress default "5432")

`DB_USERNAME`: Username database yang akan digunakan

`DB_PASSWORD`: Password database yang sesuai dengan name database



## API Reference

Untuk mengakses API yang telah dibuat bisa menggunakan Swagger 

`DB_HOST`:`API_PORT`/swagger-ui/index.html

#### Get all Employee

```http
  GET /employee
```

#### Get Learning Path

```http
  GET /learning-path
```

#### Get Syllabus

```http
  GET /syllabus
```

##### Selengkapnya dapat dilihat pada halaman swagger untuk menggunakan fitur create dan find
