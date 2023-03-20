// Auto-generated by the postman-to-k6 converter

import "./libs/shim/core.js";
import "./libs/shim/urijs.js";

export let options = { maxRedirects: 4 };

const Request = Symbol.for("request");
postman[Symbol.for("initial")]({
  options,
  collection: {
    BASE_URL: "http://localhost:8080/"
  }
});

export default function() {
  postman[Request]({
    name: "Get Users",
    id: "12604325-db8b-4452-9f90-ef29e161d0ed",
    method: "GET",
    address: "{{BASE_URL}}api/v1/user/",
    pre() {
      pm.environment.get("variable_key");
    }
  });

  postman[Request]({
    name: "Get User",
    id: "feeb3bd0-8c66-4c25-bfb2-2afc6d3c9d94",
    method: "GET",
    address: "{{BASE_URL}}api/v1/user/43e3af93-b4da-44c2-9533-9f55734b5b7c"
  });
}