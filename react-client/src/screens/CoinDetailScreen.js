
import React, { Component } from 'react';
import { useState } from 'react';
import { Card, Col, Container, Row, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import AddReportModal from '../components/AddReportModal';
import Header from '../components/header';

class CoinDetailScreen extends Component {

    constructor(props) {
        super(props)
        this.state = {
            menuOpen: false,
            loading: true,
            item: [],
        }
    }

    fetchData(coinId) {
        // alert("called")
        this.setState({
            loading: true
        })
        fetch("http://localhost:8080/crypto-adviser/report?id=" + coinId)
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result);
                    this.setState({
                        loading: false,
                        item: result
                    });
                },

                (error) => {
                    this.setState({
                        loading: false,
                        error
                    });
                }
            )
    }

    componentDidMount() {
        this.fetchData(this.props.match.params.id)

    }



    render() {
        return (
            <div className="wrapper home">
                <Header title="home" left="bars" right="redo" />

                <div className="main-container">
                    <Container>
                        
                        <Row className="mt-5 ">
                            <Col className="text-right bg-white rounded">
                                <Button variant="info my-3" onClick={() => AddReportModal.setShowAddModal(true)}>
                                    Add
                                </Button>
                            </Col>
                        </Row>
                        <Row className="mt-5">
                            <Col>
                                <Card className="text-center mb-3">
                                    <Card.Header>{"Report " + this.state.item.id}</Card.Header>
                                    <Card.Body>
                                        <Card.Title>{this.state.item.title}</Card.Title>
                                        <Card.Text>
                                        {this.state.item.content}
                                        </Card.Text>
                                    </Card.Body>
                                    <Card.Footer className="text-muted">{this.state.item.created_at}</Card.Footer>
                                </Card>

                                {
                                    AddReportModal.showAddModal &&
                                    <AddReportModal
                                        show={AddReportModal.showAddModal}
                                        
                                        close={() => AddReportModal.setShowAddModal(false)}
                                    />
                                }
                            </Col>
                        </Row>
                    </Container>
                </div>

            </div>
        );


    }
}
export default CoinDetailScreen

// export default function CoinDetailScreen(props) {

//     let coinId = props.match.params.id;
//     console.log("CoinID")
//     console.log(coinId)
//     const [showAddModal, setShowAddModal] = useState(false)

//     let item = undefined
//     fetch("http://localhost:8080/crypto-adviser/report?id=" + coinId)
//         .then(res => res.json())
//         .then(
//             (result) => {
//                 item = result
//             },

//             (error) => {

//             }
//         )

//     console.log("TT" + item)
//     return (
//         <div className="wrapper home">
//             <Header title="home" left="bars" right="redo" />

//             <div className="main-container">
//                 <Container>
//                     <Row className="mt-5 ">
//                         <Col className="text-right bg-white rounded">
//                             <Button variant="info my-3" onClick={() => setShowAddModal(true)}>
//                                 Add
//                             </Button>
//                         </Col>
//                     </Row>
//                     <Row className="mt-5">
//                         <Col>
//                             <Card className="text-center mb-3">
//                                 <Card.Header>{item.title}</Card.Header>
//                                 <Card.Body>
//                                     <Card.Title>Special title treatment</Card.Title>
//                                     <Card.Text>
//                                         With supporting text below as a natural lead-in to additional content.
//                                     </Card.Text>
//                                 </Card.Body>
//                                 <Card.Footer className="text-muted">2 days ago</Card.Footer>
//                             </Card>

//                             {
//                                 showAddModal &&
//                                 <AddReportModal
//                                     show={showAddModal}
//                                     close={() => setShowAddModal(false)}
//                                 />
//                             }
//                         </Col>
//                     </Row>
//                 </Container>
//             </div>

//         </div>
//     );


// }
