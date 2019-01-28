import Config from "./../models/Config"

const port = (process.env.PORT && parseInt(process.env.PORT)) || 2019
const id = process.env.ID || "random-uuid-here"

const secret = process.env.SECRET || "IW€@rMy$unGl@ss3s@N8"

const defaultConfig: Config = {
    port,
    auth: {
        id,
        secret
    }
}

export default defaultConfig