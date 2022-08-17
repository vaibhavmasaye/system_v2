module.exports = (sequelize, Datatype) => {
  const CompanyDetails = sequelize.define("CompanyDetails", {
    sid: {
      type: Datatype.INTEGER,
    },
    company_description: {
      type: Datatype.STRING,
    },
  });

  return CompanyDetails;
};
