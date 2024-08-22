import Header from "../layout/Header"
import UserAccess from "../layout/UserAccess/UserAccess"
import Management from "./Menagement"

function Home() {
    return (
        <div className="container-home">

            <Header />
            <UserAccess />
        </div>

    )
}
export default Home