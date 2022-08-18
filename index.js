var express = require("express");
var app = express();
const db = require("./models");
const { Supplier, Supplier1, BidEmails } = require("./models");
const cors = require("cors");
var bcrypt = require("bcrypt");
var nodemailer = require("nodemailer");
var hogan = require("hogan.js");
var fs = require("fs");
var template = fs.readFileSync("./index.html", "utf-8");

app.use(express.json());
app.use(cors());

let hashCode;
let emailID;

app.post("/insert", async (req, res) => {
  let bodyData = req.body;
  const salt = await bcrypt.genSalt();
  const hashpassword = await bcrypt.hash(req.body.password, salt);
  console.log(salt);
  console.log(hashpassword);

  Supplier.create({ ...bodyData, password: hashpassword }).catch((err) => {
    if (err) {
      console.log(err);
    }
  });
  res.send("inserted");

  // res.send(hashpassword);
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
  let reqBody = req.body;

  Supplier.update(reqBody, {
    where: { id: reqId },
  }).then(() => {
    console.log("Success");
    res.send(reqBody);
  });
});

app.post("/login", async (req, res) => {
  let userID = req.body.userID;
  let passWord = req.body.passWord;

  console.log(req.body.userID);

  if (req.body.userID) {
    await Supplier.findOne({ where: { email: userID } }).then((result) => {
      if (result?.email === userID) {
        if (result?.auth_status === "1") {
          bcrypt.compare(passWord, result?.password, (err, results) => {
            results
              ? res.send({
                  msg: "LoginSuccess",
                  statusCode: true,
                  userData: result,
                })
              : res.send({
                  msg: "Invalid Password",
                  statusCode: false,
                });
          });
          console.log("Athorize");
        } else {
          res.send({
            msg: "User is not Athorised",
            statusCode: false,
          });
        }
      } else {
        res.send({
          msg: "Email is Invalid",
          statusCode: false,
        });
      }
    });
  } else {
    console.log("Filds are empty");
    res.send({
      msg: "Please Enter Email And password",
      statusCode: false,
    });
  }
});

app.get("/loggedUser/:id", (req, res) => {
  let paramsId = req.params.id;
  Supplier.findOne({ where: { id: paramsId } }).then((result) => {
    console.log(result);
    res.send(result);
  });
});

// Supplier 1
app.post("/addNewSupplier/:id", (req, res) => {
  res.send(req.body);
  let bodyData = req.body;
  let idParams = req.params.data;

  console.log(idParams);

  Supplier1.create(bodyData).catch((err) => {
    if (err) {
      console.log(err);
    }
  });
  res.send("inserted");
  console.log(req.body);
});

// BID_EMAIL
app.post("/addNewBIDEmail/:id", (req, res) => {
  res.send(req.body);
  let bodyData = req.body;
  let SupllierId = req.params.data;

  console.log(SupllierId);

  BidEmails.create(bodyData).catch((err) => {
    if (err) {
      console.log(err);
    }
  });
  res.send("Inserted");
  console.log(req.body);
});

// Send Verification Link
app.post("/sendVerificationMail", (req, res) => {
  hashCode = req.body.hashCode;
  emailID = req.body.email;

  let transporter = nodemailer.createTransport({
    service: "gmail",
    auth: {
      user: "sagar.borude@miratsinsights.com",
      pass: "8805189617",
    },
  });

  let mailOptions = {
    from: "sagar.borude@miratsinsights.com",
    to: emailID,
    subject: "Nodemailer - Test",
    text: `http://localhost:3000/verifyLink/`,
    html: `<p> http://localhost:3000/verifyLink/${hashCode} </p>`,
  };

  transporter.sendMail(mailOptions, (err, data) => {
    if (err) {
      return log("Error occurs");
    }
    return res.send("Email Sent");
  });

  res.send("hashCode");
  console.log(hashCode);
});

app.get("/verifyLink/:vCode", (req, res) => {
  let vcode = req.params.vCode;

  console.log(hashCode);
  console.log(vcode);

  if (hashCode == vcode) {
    Supplier.update(
      { emailVerfyed: true },
      {
        where: { email: emailID },
      }
    ).then(() => {
      console.log("Success");
      res.send("Verify Successfully");
    });

    console.log(emailID);
  } else {
    console.log("Not match");
  }
});

db.sequelize.sync().then((req) => {
  app.listen(3000, function () {
    console.log("Node app is running on port 3000");
  });
});
