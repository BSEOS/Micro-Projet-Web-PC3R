import React, { Component } from "react";
import Header from "../components/header";

export default class LoginScreen extends Component {
    render() {
        return (
            <>
                <Header title="home" left="bars" right="redo" />
                <div className="auth-wrapper">
                    <div className="auth-inner">


                        <form>
                            <h3>Sign In</h3>

                            <div className="form-group mb-2">
                                <label>Email address</label>
                                <input name="email" type="email" className="form-control" placeholder="Enter email" />
                            </div>

                            <div className="form-group mb-2">
                                <label>Password</label>
                                <input name="password" type="password" className="form-control" placeholder="Enter password" />
                            </div>

                            <div className="form-group mb-2">
                                <div className="custom-control custom-checkbox">
                                    <input type="checkbox" className="custom-control-input" id="customCheck1" />
                                    <label className="custom-control-label" htmlFor="customCheck1">Remember me</label>
                                </div>
                            </div>

                            <button type="submit" className="btn btn-primary btn-block">Submit</button>
                            <p className="forgot-password text-right">
                                Forgot <a href="#">password?</a>
                            </p>
                        </form>
                    </div>
                </div>
            </>
        );
    }
}
