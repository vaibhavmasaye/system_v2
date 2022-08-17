module.exports = (sequelize, Datatype) => {
  const BidEmails = sequelize.define("BidEmails", {
    sid: {
      type: Datatype.INTEGER,
    },
    bid_emails: {
      type: Datatype.STRING,
    },
  });

  return BidEmails;
};
