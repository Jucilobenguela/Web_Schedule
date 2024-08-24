import  HookProvider  from "../Hook/HookProvider.jsx"
import BodyMain from "../layout/BodyMain/BodyMain"
import Header from "../layout/Header/Header"

function Home() {
    return (
       
             <div className="container-home">
                <HookProvider>
                <Header />
                <BodyMain/>
                </HookProvider>
          
        </div>

       
       

    )
}
export default Home