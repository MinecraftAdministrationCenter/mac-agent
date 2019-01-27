import { Request, Response, Next } from "restify"

export const helloWorld = (request: Request, response: Response, next: Next) => {
    response.json(418, "Hello World... I'm a teapot.")
    next()
}