import React, { Component } from 'react';
import { Button, Form, FormControl, Nav, Navbar, NavDropdown, Tooltip } from 'react-bootstrap';
import { Link } from 'react-router-dom';
// import { slide as Menu } from 'react-burger-menu'
// import helpers from '../utils/helpers';


class Header extends Component {

    constructor(props) {
        super(props)
        this.state = {
            menuOpen: false,
        }
        // console.log('this.props.history', this.props.history)
    }

    componentDidMount() {

        // this.isDesktop = helpers.isDesktop()
        // console.log('this.isDesktop', this.isDesktop)
    }

    handleStateChange(state) {
        this.setState({ menuOpen: state.isOpen })
    }
    toggleMenu() {
        this.setState(state => ({ menuOpen: !state.menuOpen }))
    }

    _userTooltip(props) {
        return <Tooltip {...props}>profile</Tooltip>;
    }
    _starredTooltip(props) {
        return <Tooltip {...props}>faves</Tooltip>;
    }
    _addPostTooltip(props) {
        return <Tooltip {...props}>add post</Tooltip>;
    }
    _exploreTooltip(props) {
        return <Tooltip {...props}>search</Tooltip>;
    }
    _homeTooltip(props) {
        return <Tooltip {...props}>home</Tooltip>;
    }

    render() {
        return (
            <header>
                <Navbar bg="light" expand="lg" className="px-3">
                    <Navbar.Brand href="/">Crypto Adviser</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse className="justify-content-between ">
                        <Nav className="mr-auto">
                            <Nav.Link href="/">Home</Nav.Link>
                            <Nav.Link href="/global">Global</Nav.Link>
                            <Nav.Link href="#link">Link</Nav.Link>

                        </Nav>

                        <Nav className="">
                            <Link to="/login" className="nav-link">
                                Sign in / Sign up
                            </Link>
                        </Nav>

                    </Navbar.Collapse>
                </Navbar>



            </header>

        );


    }
}
export default Header