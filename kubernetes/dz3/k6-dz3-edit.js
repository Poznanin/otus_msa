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
    id: "971bbf5e-9185-4e0d-9dbd-5c1de33528c4",
    method: "GET",
    address: "http://arch.homework/otusapp/poznanin/api/v1/user/"
  });

  postman[Request]({
    name: "Create User",
    id: "c8a4ecfa-6304-4a9f-98e8-9c8e3e63d382",
    method: "POST",
    address: "http://arch.homework/otusapp/poznanin/api/v1/user/",
    data:
      '{\r\n  "id": "d46faa86-b816-4c50-82cf-7b25d48ca9f6",\r\n  "name": "Петр",\r\n  "firstName": "Петрович",\r\n  "lastName": "Петров",\r\n  "mail": "pp.petrov@arch.homework",\r\n  "phone": "+79991111111"\r\n}'
  });

  postman[Request]({
    name: "Update User",
    id: "fce1175f-89d5-4c48-8c34-0fe841874030",
    method: "PUT",
    address:
      "http://arch.homework/otusapp/poznanin/api/v1/user/d46faa86-b816-4c50-82cf-7b25d48ca9f6",
    data:
      '{\r\n  "id": "d46faa86-b816-4c50-82cf-7b25d48ca9f6",\r\n  "name": "Петр 2",\r\n  "firstName": "Петрович",\r\n  "lastName": "Петров",\r\n  "mail": "pp.petrov@arch.homework",\r\n  "phone": "+79991111111"\r\n}'
  });

  postman[Request]({
    name: "Get User",
    id: "36031cca-34e5-497f-9abe-a6e9de3d8151",
    method: "GET",
    address:
      "http://arch.homework/otusapp/poznanin/api/v1/user/d46faa86-b816-4c50-82cf-7b25d48ca9f6"
  });

  postman[Request]({
    name: "Delete User",
    id: "e71bcddf-45f6-4d0f-9bb9-b04a28e20885",
    method: "DELETE",
    address:
      "http://arch.homework/otusapp/poznanin/api/v1/user/d46faa86-b816-4c50-82cf-7b25d48ca9f6"
  });
}