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
    id: "402823b8-16a7-4acb-8b89-ef44959e4895",
    method: "GET",
    address: "{{BASE_URL}}api/v1/user/"
  });

  postman[Request]({
    name: "Create User",
    id: "c87f958b-2694-4373-9abf-9fefb8ccbe50",
    method: "POST",
    address: "{{BASE_URL}}api/v1/user/",
    data:
      '{\r\n  "id": "d46faa86-b816-4c50-82cf-7b25d48ca9f6",\r\n  "name": "Петр",\r\n  "firstName": "Петрович",\r\n  "lastName": "Петров",\r\n  "mail": "pp.petrov@arch.homework",\r\n  "phone": "+79991111111"\r\n}'
  });

  postman[Request]({
    name: "Update User",
    id: "0df92640-aca3-4a37-8347-b98e0e857dc0",
    method: "PUT",
    address: "{{BASE_URL}}api/v1/user/d46faa86-b816-4c50-82cf-7b25d48ca9f6",
    data:
      '{\r\n  "id": "d46faa86-b816-4c50-82cf-7b25d48ca9f6",\r\n  "name": "Петр 2",\r\n  "firstName": "Петрович",\r\n  "lastName": "Петров",\r\n  "mail": "pp.petrov@arch.homework",\r\n  "phone": "+79991111111"\r\n}'
  });

  postman[Request]({
    name: "Get User",
    id: "cffd2e58-8375-4e5a-8d2d-a91a22c21ce4",
    method: "GET",
    address: "{{BASE_URL}}api/v1/user/d46faa86-b816-4c50-82cf-7b25d48ca9f6"
  });

  postman[Request]({
    name: "Delete User",
    id: "ccbdf822-f5dc-464f-91e2-1778490337b4",
    method: "DELETE",
    address: "{{BASE_URL}}api/v1/user/d46faa86-b816-4c50-82cf-7b25d48ca9f6"
  });
}