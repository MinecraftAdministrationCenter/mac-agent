import { Server } from "restify"
import { helloWorld } from "../controllers/HelloWorld"

const register = (server: Server) => {
    server.get("/helloWorld", helloWorld)
}

export { register }