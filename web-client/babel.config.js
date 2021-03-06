module.exports = {
  env: {
    production: {
      presets: ["next/babel"],
    },
    test: {
      presets: ["@babel/preset-env", "@babel/react", "next/babel"],
    },
    development: {
      presets: ["next/babel"],
    },
  },
};
