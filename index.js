var express = require("express");
var app = express();
const db = require("./models");
const { Supplier } = require("./models");
const cors = require("cors");

app.use(express.json());
app.use(cors());

app.post("/insert", (req, res) => {
  Supplier.create(req.body).catch((err) => {
    if (err) {
      console.log(err);
    }
  });
  res.send("inserted");
  console.log(req.body);
});

app.get("/view/Supplier", (req, res) => {
  Supplier.findAll()
    .then((supplier) => {
      res.send(supplier);
    })
    .catch((err) => {
      console.log(err);
    });
});

app.get("/find/user/:email/:password", (req, res) => {
  let paramEmail = req.params.email;
  let paramPassword = req.params.password;
  Supplier.findAll({ where: { email: paramEmail, password: paramPassword } })
    .then((result) => {
      res.send(result);
    })
    .catch((err) => {
      console.log(err);
    });
});

app.put("/authorise/:id", (req, res) => {
  let reqId = req.params.id;
  console.log(reqId);

  Supplier.update(
    {
      auth_status: "Authorise",
    },
    {
      where: { id: reqId },
    }
  ).then(() => {
    console.log("Success");
  });
});

db.sequelize.sync().then((req) => {
  app.listen(3000, function () {
    console.log("Node app is running on port 3000");
  });
});
