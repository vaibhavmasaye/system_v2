module.exports = (sequelize, Datatype) => {
  const Supplier = sequelize.define("Supplier", {
    auth_status: {
      type: Datatype.STRING,
    },
    password: {
      type: Datatype.STRING,
    },
    company_name: {
      type: Datatype.STRING,
    },
    company_description: {
      type: Datatype.STRING,
    },
    company_regst_no: {
      type: Datatype.INTEGER,
    },
    start_date: {
      type: Datatype.STRING,
    },

    employee_name: {
      type: Datatype.STRING,
    },
    employee_job_title: {
      type: Datatype.STRING,
    },
    job_function: {
      type: Datatype.STRING,
    },
    email: {
      type: Datatype.STRING,
    },
    contact_number: {
      type: Datatype.STRING,
    },
    company_official_name: {
      type: Datatype.STRING,
    },
    website_url: {
      type: Datatype.STRING,
    },
    address: {
      type: Datatype.STRING,
    },
    city: {
      type: Datatype.STRING,
    },
    zipcode: {
      type: Datatype.STRING,
    },
    company_details: {
      type: Datatype.STRING,
    },
    number_of_employee: {
      type: Datatype.STRING,
    },
    annual_revenue: {
      type: Datatype.STRING,
    },
    description: {
      type: Datatype.STRING,
    },
    company_tax_id_number: {
      type: Datatype.STRING,
    },
    targeted_market: {
      type: Datatype.STRING,
    },
    targeted_industry: {
      type: Datatype.STRING,
    },
    panel_base: {
      type: Datatype.STRING,
    },
    feasibility: {
      type: Datatype.STRING,
    },
    official_email_address: {
      type: Datatype.STRING,
    },
    country: {
      type: Datatype.STRING,
    },
  });
  return Supplier;
};
