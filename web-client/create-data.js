const uuid = require("uuid");
const fs = require("fs");
const fileName = "../server/repo/src/main/resources/data.json";
const frFileName = "../server/repo/src/main/resources/data_fr.json";
const enJson = require(fileName);
const frJson = require(frFileName);
const axios = require("axios").default;

const translateText = async (text, to) => {
  const body = `
    [
        {
            "Text": "${text}"
        }
    ]`;
  const baseUrl = `https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=${to}`;
  try {
    console.log("start");
    const res = await axios.post(baseUrl, JSON.parse(body), {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
        "Ocp-Apim-Subscription-Key": "533ec17774534ccea0ce1bed8196923f",
        "Ocp-Apim-Subscription-Region": "canadacentral",
      },
    });
    const trans = res.data[0].translations[0];
    console.log({ text: trans.text });
    return trans.text;
  } catch (err) {
    console.log({ err });
  }
};

const start = async () => {
  for (const aCategory of enJson.assets) {
    aCategory.meta.id = uuid.v4();
    for (const a of aCategory.items) {
      a.lineItem.id = uuid.v4();
    }
  }
  for (const aCategory of enJson.liabilities) {
    aCategory.meta.id = uuid.v4();
    for (const a of aCategory.items) {
      a.lineItem.id = uuid.v4();
    }
  }

  for (const aCategory of frJson.assets) {
    aCategory.meta.name = await translateText(aCategory.meta.name, "fr");
    for (const a of aCategory.items) {
      a.lineItem.name = await translateText(a.lineItem.name, "fr");
    }
  }
  for (const aCategory of frJson.liabilities) {
    aCategory.meta.name = await translateText(aCategory.meta.name, "fr");
    for (const a of aCategory.items) {
      a.lineItem.name = await translateText(a.lineItem.name, "fr");
    }
  }

  fs.writeFileSync(fileName, JSON.stringify(enJson));
  fs.writeFileSync(frFileName, JSON.stringify(frJson));
};

start();
