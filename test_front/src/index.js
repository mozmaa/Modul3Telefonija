import React, { useState } from 'react'
import { createRoot } from 'react-dom/client'
import { Link, Navigate, Route, BrowserRouter as Router, Routes } from 'react-router-dom'
import Home from './components/Home'
import { Navbar, Nav, Container, Button } from 'react-bootstrap'
import { logout } from './services/auth'
import NotFound from './NotFound'
import Login from './authorization/Login'
import { jwtDecode } from 'jwt-decode'
import { Pretplate } from './components/pretplate/Pretplate'
import { AddPretplata } from './components/pretplate/AddPretplata'
import { EditPretplata } from './components/pretplate/EditPretplata'



const App = () => {

    let loggedIn = !!localStorage.getItem('jwt') ? jwtDecode(localStorage.getItem('jwt')) : null
    // console.log(loggedIn)
    const loginInfo = {
        isAdmin: loggedIn?.role.authority === 'ROLE_ADMIN',
        isUser: loggedIn?.role.authority === 'ROLE_KORISNIK',
        name: loggedIn?.sub
    }

    const[selectedPretplata, setSelectedPretplata] = useState({})

    if(window.localStorage['jwt']){
        return(
        <>
            <Router>
                <Navbar expand bg="dark" variant="dark">
                    <Navbar.Brand style={{marginLeft:10}} as={Link} to='/'>JWD</Navbar.Brand>
                    <Nav>
                        <Nav.Link as={Link} to='/pretplate'>
                            Pretplate
                        </Nav.Link>
                        <Button onClick={logout}>Logout</Button>
                    </Nav>
                </Navbar>
                <Container style={{paddingTop:"10px"}}>
                    <Routes>
                        <Route path='/' element={<Home/>}/>
                        <Route path='/pretplate' element={<Pretplate callback={(pretplata) => setSelectedPretplata(pretplata)} loginInfo= {loginInfo}/>}/>
                        <Route path='pretplata/edit' element={<EditPretplata selectedPretplata={selectedPretplata}/>} />
                        <Route path='/pretplate/dodavanje' element={<AddPretplata/>} />
                        <Route path="*" element={<NotFound />} />
                    </Routes>
                </Container>
            </Router>
        </>
        )
        }else{
            return(
            <>
            <Router>
                <Navbar expand bg="dark" variant="dark">
                    <Navbar.Brand style={{marginLeft:10}} as={Link} to='/'>JWD</Navbar.Brand>
                    <Nav>
                        <Nav.Link as={Link} to='/pretplate'>
                            Pretplate
                        </Nav.Link>
                        <Nav.Link as={Link} to='/login'>
                            Login
                        </Nav.Link>
                    </Nav>
                </Navbar>
                <Container style={{paddingTop:"10px"}}>
                    <Routes>
                        <Route path='/' element={<Home/>}/>
                        <Route path='/pretplate' element={<Pretplate/>}/>
                        <Route path='/login' element={<Login/>}/>
                        <Route path="*" element={<Navigate replace to = "/login" />} />
                    </Routes>
                </Container>
            </Router>
        </>
        )}
}

const rootElement = document.getElementById('root')
const root = createRoot(rootElement)

root.render(
    <App/>
)