module.exports = (sequelize, Datatype) => {
  const User = sequelize.define("User", {
    firstName: {
      type: Datatype.STRING,
      allowNull: false,
      validate: {
        notEmpty: true,
      },
    },
    age: {
      type: Datatype.INTEGER,
      allowNull: false,
      validate: {
        notEmpty: true,
      },
    },
  });
  return User;
};
