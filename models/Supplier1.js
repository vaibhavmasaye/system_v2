module.exports = (sequelize, Datatype) => {
  const Supplier1 = sequelize.define("Supplier1", {
    sid: {
      type: Datatype.INTEGER,
      primaryKey: true,
    },
    MoonKnightDetails: {
      type: Datatype.STRING,
    },
    bid_contact_name: {
      type: Datatype.STRING,
    },
    bid_emails_cc: {
      type: Datatype.STRING,
    },
    company_email: {
      type: Datatype.STRING,
    },
    company_name: {
      type: Datatype.STRING,
    },
  });

  return Supplier1;
};
