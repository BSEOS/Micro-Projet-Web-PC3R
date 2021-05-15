import React, { Component } from 'react';
import { Col, Container, Row, Table } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Header from '../components/header';


class HomeScreen extends Component {

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



    render() {
        return (
            <div className="wrapper home">
                <Header title="home" left="bars" right="redo" />

                <div className="main-container">
                    <Container>
                        <Row className="mt-5">
                            <Col>
                                <h3 className="text-white text-center mb-3">
                                    Live currency prices
                                </h3>
                                <Table striped bordered hover size="sm" className="bg-white">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>
                                                Coin
                                            </th>
                                            <th>Price</th>
                                            <th>Market</th>
                                            <th>24h volume</th>
                                            <th>1h</th>
                                            <th>24h</th>
                                            <th>7d</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>
                                                <Link to={"/coins/{id}"}>
                                                    Bitcoin
                                                </Link>
                                            </td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>@mdo</td>
                                            <td>@mdo</td>
                                            <td>@mdo</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>
                                                <Link to={"/coins/{id}"}>
                                                    Bitcoin
                                                </Link>
                                            </td>
                                            <td>Thornton</td>
                                            <td>@fat</td>
                                            <td>@fat</td>
                                            <td>@fat</td>
                                            <td>@fat</td>
                                            <td>@fat</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td colSpan="2">Larry the
                                                <Link to={"/coins/{id}"}>
                                                    Bitcoin
                                                </Link>
                                            </td>
                                            <td>@twitter</td>
                                            <td>@twitter</td>
                                            <td>@twitter</td>
                                            <td>@twitter</td>
                                            <td>@twitter</td>
                                        </tr>
                                    </tbody>
                                </Table>
                            </Col>
                        </Row>
                    </Container>
                </div>

            </div>
        );


    }
}
export default HomeScreen