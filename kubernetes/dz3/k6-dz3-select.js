// Auto-generated by the postman-to-k6 converter

import "./libs/shim/core.js";

export let options = { maxRedirects: 4 };

const Request = Symbol.for("request");
postman[Symbol.for("initial")]({
  options
});

export default function() {
  postman[Request]({
    name: "Get Users",
    id: "a4b31e15-29cf-43c8-ae91-5a1a48cd8ac2",
    method: "GET",
    address: "http://arch.homework/otusapp/poznanin/api/v1/user/"
  });

  postman[Request]({
    name: "Get User",
    id: "b5a00344-06e8-4f0e-b510-66c3aea1b99e",
    method: "GET",
    address:
      "http://arch.homework/otusapp/poznanin/api/v1/user/d46faa86-b816-4c50-82cf-7b25d48ca9f6"
  });
}