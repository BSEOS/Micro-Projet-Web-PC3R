
import React, { Component } from 'react';
import { Card, Col, Container, Row, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Header from '../components/header';


class CoinSummaryScreen extends Component {

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
                                <Card className="text-left mb-3">
                                    <Card.Header className="mt-2">
                                        <h3 className="mr-auto">Title of the summary</h3>
                                    </Card.Header>
                                    <Card.Body>
                                        <Card.Title>author of the summary</Card.Title>
                                        <Card.Text>
                                            With supporting text below as a natural lead-in to additional content.
                                        </Card.Text>
                                        <Link to="/coins/{id}/summary/{id}" className="btn btn-primary">Go somewhere</Link>
                                    </Card.Body>
                                    <Card.Footer className="text-muted">2 days ago</Card.Footer>
                                </Card>

                            </Col>
                        </Row>



                        <Row class="row d-flex justify-content-center mt-100">
                            <Col xs={12} md={10} className="m-auto text-left">
                                <div class="card px-3 py-4">
                                    <div class="card-body text-center">
                                        <h4 class="card-title">Latest Comments</h4>
                                    </div>
                                    <div class="comment-widgets">

                                        <div class="d-flex flex-row comment-row mb-4">
                                            <div class="p-2">
                                                <img src="https://i.imgur.com/Ur43esv.jpg" alt="user" width="50" class="rounded-circle mr-2" />
                                            </div>
                                            <div class="comment-text w-100">
                                                <h6 class="font-medium">James Thomas</h6> <span class="m-b-15 d-block">This is awesome website. I would love to comeback again. </span>
                                                <div class="comment-footer"> <span class="text-muted float-right">April 14, 2019</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </Col>
                        </Row>

                        <Row className="mt-2">
                            <Col xs={12} md={10} className="m-auto text-left">
                                <div class="card p-3">
                                    <h5>Add comments</h5>
                                    <textarea id="textarea" class="form-control"> </textarea>
                                    <div class="mt-3 d-flex justify-content-between align-items-center">
                                        <span id="count"></span>
                                        <button class="btn btn-sm btn-danger">Submit</button>
                                    </div>
                                </div>
                            </Col>
                        </Row>

                    </Container>
                </div>

            </div>
        );


    }
}
export default CoinSummaryScreen