import React, { useEffect } from 'react';
import { Modal, Button } from 'react-bootstrap';

export default function AddReportModal(props) {


	useEffect(() => {
	}, [])


	return (
		<Modal show={props.show} onHide={() => props.close()} centered>
			<Modal.Body className="">


				<div className="text-right mb15">

				</div>

			</Modal.Body>
			<Modal.Footer className="justify-content-start">
				<Button variant="primary" onClick={() => props.close()}>
					ok
				</Button>
				<Button variant="outline-primary" onClick={() => props.close()}>
					cancel
				</Button>
			</Modal.Footer>

		</Modal>
	)
}